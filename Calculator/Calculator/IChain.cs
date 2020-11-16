using System;
using System.Collections.Generic;
using System.Text;

namespace Calculator
{
    interface IChain
    {
        public void setNextChain(IChain nextChain);
        public void calculate(Num request);
    }
}
