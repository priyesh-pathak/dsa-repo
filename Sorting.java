class Sorting{
    // to print an array.
    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void bubbleSort(int[] arr){
        int n=arr.length;
        boolean swapped =false;
        for(int i=0;i<n;i++){
            swapped=false;
            for(int j=0;j<n-i-1;j++){ //inner loop gets short from back every round.
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    swapped=true;
                }
            }
            if(!swapped) break;
        }
        printArray(arr);
    }
    // loop i to n-1. 
    // initialise min and min Index and find the min number and minIndex
    // swap min with the i index.
    public static void selectionSort(int[] arr){
        int n=arr.length;
        int min=0;
        int minIndex=-1;
        for(int i=0;i<n;i++){
            min=arr[i];
            minIndex=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<min){
                    min=arr[j];
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[minIndex]=temp;
        }
        printArray(arr);
    }
    // assuming 0 index is sorted we si loop from i till n-1.
    // j is kept at i-1 position compared till j>-1 and j value is greater than i value.
    // then at last swapped.
    public static void insertSort(int[] arr){
        int n=arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            while(j>-1 && arr[j]> arr[i]){
                j--;
            }
            j++;
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
        printArray(arr);
    }

    // merge Sort Start ->
    public static void merge(int[] arr, int si,int mid,int ei){
        int i=si;
        int j=mid+1;
        int k=0;
        int[] ans=new int[ei-si+1];
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]) ans[k++]=arr[i++];
            else ans[k++]=arr[j++];
        }
        while(i<=mid) ans[k++]=arr[i++];
        while(j<=ei) ans[k++]=arr[j++];

        for(k=0,i=si;k<ans.length;k++,i++ ){
            arr[i]=ans[k];
        }
    }
    public static void mergeSort(int[] arr,int si,int ei){
        if(si<ei){
            int mid=si+((ei-si)/2);
            mergeSort(arr,si,mid);
            mergeSort(arr,mid+1,ei);
            merge(arr,si,mid,ei);
        }
    }

    // merge sort End...

    //quick sort si ->
    public static int partition(int[] arr,int si,int ei){
        int pivot = arr[si];
        int i = si;
        int j = ei;
        while (i < j) {
          while (arr[i] <= pivot && i < ei) i++;
          while (arr[j] > pivot && j > si) j--;
          if (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
          }
        }
        arr[si]=arr[j];
        arr[j]=pivot;
        return j;
    }
    public static void qsort(int[] arr, int si, int ei) {
        if (si < ei) {
          int pi = partition(arr, si, ei);
          qsort(arr, si, pi - 1);
          qsort(arr, pi + 1, ei);
        }
      }
    //quick sort ends...
    public static void main(String[] args) {
        int[] nums = {7,4,1,5,3};
        // bubbleSort(nums);
        //selectionSort(nums);
        // insertSort(nums);
        // mergeSort(nums, 0, nums.length-1);
        //qsort(nums, 0, nums.length-1);
    }
}