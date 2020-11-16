using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;
using System.Threading.Channels;

namespace Calculator
{
    class Add : IChain
    {

        private IChain nextChain;

        public void calculate(Num request)
        {
            if (Equals(request.getCalc(),"add"))
            {
                double res = request.getNum1() + request.getNum2();
                Console.WriteLine("The result of adding is :" + res );
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
