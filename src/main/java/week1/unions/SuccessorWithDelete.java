package week1.unions;

public class SuccessorWithDelete {

   private int nodes[];
   private final int DELETION_TAG = -1;
   private final int DEFAULT_MAX = -1;
   private int nextVal;

   public SuccessorWithDelete(int size) {
      nodes = new int[size];

      for (int i = 0; i < size; i++)
         nodes[i] = i;
   }

   public void delete(int index) {
      nodes[index] = DELETION_TAG;

      if (index < nodes.length - 1 && index >= 0 && nodes[index+1] != DELETION_TAG)
         nextVal = nodes[index+1];
   }

   public int successor(int x) {
      if (0 <= x && x < nodes.length){
         if(nodes[x] != DELETION_TAG && x <= nodes[x]) {
            nextVal = nodes[x];
            return nextVal;
         }

         if (x <= nextVal)
            return nextVal;
      }

      return DELETION_TAG;
   }
}
