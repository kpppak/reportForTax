public class Total {
    public int checkAmount;
    public int maxCheckValue;

    public Total(int checkAmount, int maxCheckValue){
        this.checkAmount = checkAmount;
        this.maxCheckValue = maxCheckValue;
    }

    public int[] shopReport(){
        int[] array = new int[checkAmount];
        for (int i = 0; i < array.length; i++){
            array[i] = (int) Math.round((Math.random() * maxCheckValue));
        }
        return array;
    }
}
