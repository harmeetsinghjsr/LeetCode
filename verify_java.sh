#!/bin/bash

echo "=== Java Code Verification Script ==="
echo "Compiling all Java files and reporting status..."

compiled=0
failed=0

for file in *.java; do
    if [ -f "$file" ]; then
        echo -n "Testing $file... "
        if javac "$file" 2>/dev/null; then
            echo "✓ PASS"
            ((compiled++))
        else
            echo "✗ FAIL"
            ((failed++))
            echo "  Compilation errors:"
            javac "$file" 2>&1 | sed 's/^/    /'
        fi
    fi
done

echo ""
echo "=== Summary ==="
echo "Compiled successfully: $compiled"
echo "Failed compilation: $failed"

if [ $failed -eq 0 ]; then
    echo "🎉 All Java files are working for sure!"
    exit 0
else
    echo "❌ Some files need fixes"
    exit 1
fi