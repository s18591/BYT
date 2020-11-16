using System;
using System.Collections.Generic;
using System.Text;

namespace Calculator
{
    class Substract : IChain
    {
        private IChain nextChain;
        public void calculate(Num request)
        {
            if (Equals("sub", request.getCalc()))
            {
                double res = request.getNum1() - request.getNum2();
                Console.WriteLine("The result of sub is : " + res);
            }
            else
            {
                nextChain.calculate(request);
            }
        }

        public void setNextChain(IChain nextChain)
        {
            this.nextChain = nextChain;
        }
    }
}
