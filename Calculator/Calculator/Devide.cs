using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using System.Threading.Channels;

namespace Calculator
{
    class Devide : IChain
    {

        private IChain nextChain;

        public void calculate(Num request)
        {
            if (Equals(request.getCalc(), "dev"))
            {
                double res = request.getNum1() / request.getNum2();
                Console.WriteLine("The result of deviding is :" + res);
            }
            else
            {
                Console.WriteLine("Not working. Type add, sub, mul or dev");
            }
        }

        public void setNextChain(IChain nextChain)
        {
            this.nextChain = nextChain;
        }
    }
}
