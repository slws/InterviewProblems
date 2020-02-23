import java.util.HashSet;
import java.util.Arrays;
class Main {
  //Set up test conditions
  public static void main(String[] args) {
        Integer[] top = new Integer[]{1,7,14,21,28};
        Integer[] bottom = new Integer[]{35,42,49,56,63};
        Integer target = 1;
        compare(top, bottom, target);  
  }
  //Receive arrays and target, put into sets for optimal performance
  public static int[] compare(Integer[] topArray, Integer[] bottomArray, Integer target) {
    int[] output = new int[]{0,0};
    Double shortest = -1.0;
    Double distance = 0.0;
    HashSet<Integer> topset = new HashSet<Integer>(Arrays.asList(topArray));  
    HashSet<Integer> bottomset = new HashSet<Integer>(Arrays.asList(bottomArray));
    //Breakpoint for exact matches
    outerloop:
    for(int top : topset){
      for(int bottom : bottomset){
        int combo = top + bottom;
        //Check for exact match and break loop if found
        if (combo == target) {
          output[0] = top;
          output[1] = bottom;
          break outerloop;
        } else {
          //Invert negative differences for comparison
          distance = Math.sqrt(Double.valueOf((target - combo) * (target - combo)));
          if((shortest > distance) || (shortest < 0)){
            shortest = distance;
            output[0] = top;
            output[1] = bottom;
          }
        }
      }
    }
    //View Output
    //System.out.println(Arrays.toString(output));
    return output;
  }
}
