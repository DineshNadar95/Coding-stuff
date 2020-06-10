public class QuickSort {

    public static void QSort(int[] array, int low, int high){
        if(low < high){
            int pIndex = partition(array,low,high);
            QSort(array, low, pIndex - 1);
            QSort(array, pIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int pIndex = low;
        
        // 10 80 30 90 40 50 70
        // 10 30 80 90 40 50 70
        for(int j=low; j < high; j++){
            if(arr[j] < pivot){
                // swap arr[j] & arr[pIndex]
                int temp = arr[pIndex];
                arr[pIndex] = arr[j];
                arr[j] = temp;
                pIndex++;
            }
        }

        // shift pivot
        int temp = arr[pIndex]; 
        arr[pIndex] = arr[high]; 
        arr[high] = temp; 

        return pIndex;
    }


    public static void main(String[] args) {
        int[] array = { 10, 80, 30, 90, 40, 50, 70 };

        int low = 0;
        int high = array.length - 1;

        QSort(array, low, high);

        for(int x: array)
            System.out.print(x+"\t");
    }

}