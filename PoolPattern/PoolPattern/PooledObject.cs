using System;
using System.Collections.Generic;
using System.Text;

namespace PoolPattern
{
    class PooledObject
    {
        public string name;

        public PooledObject(string name)
        {
            this.name = name;
        }

        public string getName()
        {
            return name;
        }
    }
}
