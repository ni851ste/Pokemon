package ownUtil;

public class TwoTouple
{
    private int left;
    private int right;

    public TwoTouple(int left, int right)
    {
        this.left = left;
        this.right = right;
    }

    public TwoTouple(TwoTouple iT)
    {
        this.left = iT.left;
        this.right = iT.right;
    }

    public void change(int left, int right)
    {
        this.left = left;
        this.right = right;
    }

    //left 0
    //right 1
    public int[] get()
    {
        int[] both = {left, right};
        return both;
    }

    public int get(int i)
    {
        switch (i)
        {
            case 0:
                return this.left;
            case 1:
                return this.right;
        }
        return -1;
    }

}
