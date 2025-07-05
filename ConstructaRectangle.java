
public class ConstructARectangle {
    public int[] constructRectangle(int area) {
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{Math.max(i, area / i), Math.min(i, area / i)};
            }
        }
        return new int[]{area, 1};
    }
    public static void main(String[] args) {
        ConstructARectangle obj = new ConstructARectangle();
        int area = 122122;
        int[] result = obj.constructRectangle(area);
        System.out.println("Result: [" + result[0] + ", " + result[1] + "]");
    }
}