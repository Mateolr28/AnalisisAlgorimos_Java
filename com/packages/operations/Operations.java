package com.packages.operations;

public class Operations
{
    public int sumNaturals(int n)
    {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        return s;
    }

    public int factorial(int n)
    {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}