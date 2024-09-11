//Leetcode Problem 2220. Minimum Bit Flips to Convert Number
public class MinBitFloptoConvert {
    // public int minFlips(int a, int b, int c) {
    //     int count = 0;
    //     for(int i = 0; i < 32; i++){
    //         int bitA = (a >> i) & 1;
    //         int bitB = (b >> i) & 1;
    //         int bitC = (c >> i) & 1;
    //         if(bitC == 0){
    //             if(bitA == 1 && bitB == 1){
    //                 count += 2;
    //             }else if(bitA == 1 || bitB == 1){
    //                 count++;
    //             }
    //         }else{
    //             if(bitA == 0 && bitB == 0){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    public int minBitFlips(int start, int goal) {
        int ans = 0; 
        // XOR will give 1 where the bits are different
        int xor = start ^ goal;

        while(xor!=0){
            // If the last bit is 1, increment count 
            ans += xor & 1;

            // Right-shift to check the next bit
            xor >>=1;
        }
        return ans;
    }
}