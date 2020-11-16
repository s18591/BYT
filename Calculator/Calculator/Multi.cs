using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using System.Threading.Channels;

namespace Calculator
{
    class Multi : IChain
    {

        private IChain nextChain;

        public void calculate(Num request)
        {
            if (Equals(request.getCalc(), "mul"))
            {
                double res = request.getNum1() * request.getNum2();
                Console.WriteLine("The result of multi is :" + res);
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
