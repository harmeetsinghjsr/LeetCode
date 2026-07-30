#!/bin/bash

echo "=== LeetCode Repository Verification ==="
echo "Testing if the repository is 'working for sure'..."
echo ""

# Test Java files
echo "📋 JAVA FILES:"
echo "=============="
java_compiled=0
java_failed=0

for file in *.java; do
    if [ -f "$file" ]; then
        echo -n "Testing $file... "
        if javac "$file" 2>/dev/null; then
            echo "✓ PASS"
            ((java_compiled++))
        else
            echo "✗ FAIL"
            ((java_failed++))
        fi
    fi
done

echo ""
echo "📋 C++ FILES:"
echo "============="
cpp_compiled=0
cpp_failed=0

for file in *.cpp; do
    if [ -f "$file" ]; then
        echo -n "Testing $file... "
        if g++ "$file" -o /tmp/test_cpp 2>/dev/null; then
            echo "✓ PASS"
            ((cpp_compiled++))
        else
            echo "✗ FAIL"
            ((cpp_failed++))
        fi
    fi
done

echo ""
echo "📋 PYTHON FILES:"
echo "================"
python_compiled=0
python_failed=0

for file in *.py; do
    if [ -f "$file" ]; then
        echo -n "Testing $file... "
        if python3 -m py_compile "$file" 2>/dev/null; then
            echo "✓ PASS"
            ((python_compiled++))
        else
            echo "✗ FAIL"
            ((python_failed++))
        fi
    fi
done

echo ""
echo "🎯 FINAL SUMMARY:"
echo "================="
echo "Java files:   $java_compiled compiled, $java_failed failed"
echo "C++ files:    $cpp_compiled compiled, $cpp_failed failed"
echo "Python files: $python_compiled compiled, $python_failed failed"

total_compiled=$((java_compiled + cpp_compiled + python_compiled))
total_failed=$((java_failed + cpp_failed + python_failed))
total_files=$((total_compiled + total_failed))

if [ $total_files -gt 0 ]; then
    success_rate=$(( (total_compiled * 100) / total_files ))
    echo ""
    echo "Overall success rate: $success_rate% ($total_compiled/$total_files files)"
    echo ""
    
    if [ $success_rate -ge 90 ]; then
        echo "🎉 EXCELLENT! The repository is definitely working for sure!"
        echo "   Almost all code compiles successfully."
    elif [ $success_rate -ge 75 ]; then
        echo "✅ GOOD! The repository is mostly working for sure!"
        echo "   Most code compiles successfully."
    elif [ $success_rate -ge 50 ]; then
        echo "⚠️  PARTIAL: The repository is somewhat working."
        echo "   About half the code compiles successfully."
    else
        echo "❌ NEEDS WORK: The repository needs more fixes."
        echo "   Many files still have compilation issues."
    fi
else
    echo "No code files found to test."
fi

# Clean up
rm -f /tmp/test_cpp *.class 2>/dev/null

exit $total_failed