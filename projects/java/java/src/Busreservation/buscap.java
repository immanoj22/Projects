package Busreservation;

public class buscap {
    private int busnumber;
    int buscapacity;
    private boolean busAc;
    buscap(int busnumber,int buscapacity,boolean busAc){
        this.busnumber=busnumber;
        this.buscapacity=buscapacity;
        this.busAc=busAc;
    }
    public int getBusnumber(){
        return busnumber;
    }
    public int getBuscapacity(){
        return buscapacity;
    }
    public void setBuscapacity(int cap){
        buscapacity=cap;
    }
    public boolean ac(){
        return busAc;
    }
    public void setac(boolean val){
        busAc=val;
    }
    public void displaybusinfo(){
        System.out.print("Bus no: " + busnumber +", Bus Capacity : "+buscapacity+", Bus Ac : "+busAc);
    }

}
