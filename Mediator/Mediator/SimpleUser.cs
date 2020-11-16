using System;
using System.Collections.Generic;
using System.Text;

namespace Mediator
{
    class SimpleUser : IUser
    {
        IMediator mediator;
        string name;


        public SimpleUser(IMediator mediator, string name)
        {
            this.mediator = mediator;
            this.name = name;
        }

        public IMediator getMediator()
        {
            return mediator;
        }
        public string getName()
        {
            return name;
        }

        public void getMassega(string messege)
        {
            Console.WriteLine(this.name + " recive messege : " + messege + ".");
        }

        public void sendMassage(string mesegge)
        {
            mediator.Notify(this, mesegge);
        }
    }
}
