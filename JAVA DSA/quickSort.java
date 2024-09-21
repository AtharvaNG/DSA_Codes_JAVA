
public class quickSort {
	
	public static int partition(int arr[],int si,int ei){
		int j=si-1;
		int pivote=ei;
		int temp;
		for(int i=si;i<ei;i++){
			if(arr[i]<arr[pivote]){
				j++;
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		j++;
		temp=arr[j];
		arr[j]=arr[pivote];
		arr[pivote]=temp;

		return j;
	}
	public static void quickSortt(int[] input,int si, int ei) {
		if(si>=ei){
			return ;
		}
		int partitionIndex=partition(input,si,ei);
		quickSortt(input,si,partitionIndex-1);
		quickSortt(input,partitionIndex+1,ei);
		
	}
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void main(String[] args) {
        int arr[]={23,67,9,32,67};
        quickSortt(arr, 0, arr.length-1);
		printArray(arr);
    }
	
}