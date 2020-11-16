using System;
using System.Collections.Generic;
using System.Text;

namespace Mediator
{
    interface IMediator
    {
        void Notify(object sender, string ev);
    }
}
