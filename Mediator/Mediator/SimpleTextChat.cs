using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;

namespace Mediator
{
    class SimpleTextChat : IMediator
    {
        IUser admin;
        List<IUser> users = new List<IUser>();

        public void setAdmin(IUser admin)
        {
            this.admin = admin;
        }

        public void addUser(IUser user)
        {
            this.users.Add(user);
        }

        public void Notify(object sender, string ev)
        {
            foreach(IUser u in this.users)
            {
                if (u != sender)
                {
                    u.getMassega(ev);
                }
            }
            admin.getMassega(ev);
        }
    }
}
