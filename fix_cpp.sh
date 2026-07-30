#!/bin/bash

echo "=== Auto-fixing C++ compilation issues ==="

# Function to add missing includes to C++ files
add_cpp_includes() {
    local file="$1"
    local needs_vector=false
    local needs_string=false
    local needs_algorithm=false
    local needs_iostream=false
    
    # Check what includes are needed
    if grep -q -E "(vector|Vector)" "$file" && ! grep -q "#include.*vector" "$file"; then
        needs_vector=true
    fi
    
    if grep -q -E "(string|String)" "$file" && ! grep -q "#include.*string" "$file"; then
        needs_string=true
    fi
    
    if grep -q -E "(sort|max|min|greater)" "$file" && ! grep -q "#include.*algorithm" "$file"; then
        needs_algorithm=true
    fi
    
    if grep -q -E "(cout|cin|endl)" "$file" && ! grep -q "#include.*iostream" "$file"; then
        needs_iostream=true
    fi
    
    if [ "$needs_vector" = true ] || [ "$needs_string" = true ] || [ "$needs_algorithm" = true ] || [ "$needs_iostream" = true ]; then
        echo "Adding includes to $file"
        
        # Create temp file with includes
        {
            # Add includes
            [ "$needs_iostream" = true ] && echo "#include <iostream>"
            [ "$needs_vector" = true ] && echo "#include <vector>"
            [ "$needs_string" = true ] && echo "#include <string>"
            [ "$needs_algorithm" = true ] && echo "#include <algorithm>"
            echo "using namespace std;"
            echo ""
            
            # Add rest of file
            cat "$file"
        } > "${file}.tmp"
        
        mv "${file}.tmp" "$file"
    fi
}

# Fix C++ files
for file in *.cpp; do
    if [ -f "$file" ]; then
        echo "Processing $file..."
        add_cpp_includes "$file"
        
        # Add main function if missing
        if ! grep -q "int main" "$file"; then
            echo "
int main() {
    // TODO: Add test cases
    return 0;
}" >> "$file"
        fi
    fi
done

echo "C++ auto-fix complete."