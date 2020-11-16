using System;
using System.Globalization;

namespace Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            IChain chain1 = new Add();
            IChain chain2 = new Substract();
            IChain chain3 = new Multi();
            IChain chain4 = new Devide();

            chain1.setNextChain(chain2);
            chain2.setNextChain(chain3);
            chain3.setNextChain(chain4);

            Num request = new Num(2, 4, "add");
            chain1.calculate(request);
        }
    }
}
