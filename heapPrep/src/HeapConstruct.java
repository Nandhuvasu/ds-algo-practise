import java.util.*;

public class HeapConstruct {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            System.out.println("Array input"+ array);
            heap = buildHeap(array);
            System.out.println("Array built"+ heap);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            // Write your code here.
            int lastParentIdx = (array.size() - 2)/2;
            System.out.println("last parent"+ lastParentIdx);
            for(int currentIdx = lastParentIdx; currentIdx >=0; currentIdx--){
                System.out.println("last parent"+ currentIdx);
                siftDown(currentIdx, array.size()-1, array);
                System.out.println("array after shift"+ array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            System.out.println("current index"+ currentIdx);
            System.out.println("end idx"+ endIdx);
            System.out.println("heap"+ heap);
            // Write your code here.
            int leftChild  = (currentIdx * 2) +1;
            while(leftChild <= endIdx){
                int rightChild = (currentIdx * 2) + 2 <= endIdx ? (currentIdx * 2) + 2 : -1;
                int indexToSwap;
                if(rightChild != -1 && heap.get(rightChild) < heap.get(leftChild)){
                    indexToSwap = rightChild;
                } else {
                    indexToSwap = leftChild;
                }
                System.out.println("index to swap"+ indexToSwap);
                if(heap.get(indexToSwap) < heap.get(currentIdx)){
                    System.out.println("Going to swap");
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    leftChild = (currentIdx*2) + 1;
                } else {
                    return;
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            // Write your code here.
            int parentIdx = (currentIdx -1)/2;
            while(currentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)){
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx -1)/2;
            }
        }

        public int peek() {
            // Write your code here.
            System.out.println("Before peep"+ heap);
            return heap.get(0);
        }

        public int remove() {
            // Write your code here.
            // swap root node with end value
            swap(0, heap.size()-1, heap);
            // remove last value
            int valueRemoved = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            siftDown(0, heap.size()-1, heap);
            return valueRemoved;
        }

        public void insert(int value) {
            System.out.println(heap);
            // Write your code here.
            // add the element at last
            heap.add(value);
            // sift up the value
            siftUp(heap.size()-1, heap);
            System.out.println("After adding"+ heap);
        }

        public void swap(int pointer1, int pointer2, List<Integer> heap){
            int temp = heap.get(pointer2);
            heap.add(pointer2,heap.get(pointer1));
            heap.add(pointer1, temp);
        }
    }

    public static void main(String[] args){
        List<Integer> samplearr = new ArrayList<Integer>();
        samplearr.add(48);
        samplearr.add(12);
        samplearr.add(24);
        samplearr.add(7);
        samplearr.add(8);
        samplearr.add(-5);
        samplearr.add(24);
        samplearr.add(391);
        samplearr.add(24);
        samplearr.add(56);
        samplearr.add(2);
        samplearr.add(6);
        samplearr.add(8);
        samplearr.add(41);
        MinHeap sample = new MinHeap(samplearr);
    }
}
