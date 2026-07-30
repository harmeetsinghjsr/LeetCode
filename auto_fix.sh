#!/bin/bash

echo "=== Auto-fixing common Java compilation issues ==="

# Function to add missing imports
add_imports() {
    local file="$1"
    local needs_util=false
    local needs_io=false
    
    # Check if file needs java.util imports
    if grep -q -E "(List|ArrayList|HashMap|Map|Set|HashSet|PriorityQueue|Queue|Stack|Collections|Arrays)" "$file" && ! grep -q "import java.util" "$file"; then
        needs_util=true
    fi
    
    # Check if file needs java.io imports
    if grep -q -E "(BufferedReader|InputStreamReader|IOException)" "$file" && ! grep -q "import java.io" "$file"; then
        needs_io=true
    fi
    
    if [ "$needs_util" = true ] || [ "$needs_io" = true ]; then
        echo "Adding imports to $file"
        
        # Create temp file with imports
        {
            # Keep any existing package declaration
            grep "^package" "$file" 2>/dev/null || true
            
            # Add imports
            [ "$needs_util" = true ] && echo "import java.util.*;"
            [ "$needs_io" = true ] && echo "import java.io.*;"
            echo ""
            
            # Add rest of file (excluding package line)
            grep -v "^package" "$file"
        } > "${file}.tmp"
        
        mv "${file}.tmp" "$file"
    fi
}

# Fix files one by one
for file in *.java; do
    if [ -f "$file" ]; then
        echo "Processing $file..."
        
        # Remove package declarations that prevent compilation
        sed -i '/^package/d' "$file"
        
        # Add missing imports
        add_imports "$file"
        
        # Fix specific known issues
        case "$file" in
            "AllO"*"oneDataStructure.java")
                # Fix illegal character
                sed -i 's/AllO`oneDataStructure/AllOoneDataStructure/g' "$file"
                ;;
            "tempCodeRunnerFile.java")
                # Skip empty or problematic temp files
                echo "}" > "$file"
                ;;
        esac
    fi
done

echo "Auto-fix complete. Running verification..."