class Solution {
public:
    int tribonacci(int n) {
        // T(1) = 0
        // T(1) = 1
        // T(2) = 1
        // T(n) = T(n - 1) + T(n - 2) + T(n - 3) for n > 2
        auto third = 0, second = 1, first = 1;
        switch (n) {
            case 0:
                return third;
            case 1:
                return second;
            case 2:
                return first;
            default: {
                int current = -1;
                for (auto i = 3; i <= n; i++) {
                    current = first + second + third;
                    third = second;
                    second = first;
                    first = current;
                }
                return current;
            }
        }
    }
};
