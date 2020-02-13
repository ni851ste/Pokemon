package ownUtil;

public class TwoTouple<T>
{
    private T left;
    private T right;

    public TwoTouple(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public TwoTouple(TwoTouple<T> iT)
    {
        this.left = iT.left;
        this.right = iT.right;
    }

    public void change(T left, T right)
    {
        this.left = left;
        this.right = right;
    }

    public T get(int i)
    {
        switch (i)
        {
            case 0:
                return this.left;
            case 1:
                return this.right;
        }
        return null;
    }

}
