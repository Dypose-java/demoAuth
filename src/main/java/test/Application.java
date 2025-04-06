package test;

public class Application  {
    private  final Сalculator сalculator;

    public Application(Сalculator сalculator) {
        this.сalculator = сalculator;
    }
    void run(int num1,int num2){
        сalculator.countingNums(num1,num2);
    }
}

