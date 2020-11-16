using System;
using System.Collections.Generic;
using System.Text;

namespace Calculator
{
    class Num
    {
        private int n1;
        private int n2;
        private string calc;

        public Num(int num1, int num2,String calc)
        {
            this.n1 = num1;
            this.n2 = num2;
            this.calc = calc;
        }

        public Num()
        {
        }

        public int getNum1()
        {
            return n1;
        }
        public int getNum2()
        {
            return n2;
        }
        public String getCalc() { return calc; }
    }
}
