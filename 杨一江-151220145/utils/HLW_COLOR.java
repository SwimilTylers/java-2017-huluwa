package utils;

public enum HLW_COLOR{
    RED("红色", 0), ORANGE("橙色", 1), YELLOW("黄色", 2),
    GREEN("绿色", 3), CYAN("青色", 4), BLUE("蓝色", 5), VIOLET("紫色", 6);

    private String name;
    private int prior;

    HLW_COLOR(String name, int prior){
        this.name = name;
        this.prior = prior;
    }

    final public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getName();
    }

    final static public boolean isGreater(HLW_COLOR greater, HLW_COLOR smaller){
        if(greater == null || smaller == null)  throw null;
        return greater.prior < smaller.prior;
    }
}
