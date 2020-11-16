using System;

namespace Mediator
{
    class Program
    {
        static void Main(string[] args)
        {
            SimpleTextChat chat = new SimpleTextChat();

            IUser admin = new Admin(chat, "Admin1");
            IUser user1 = new SimpleUser(chat, "User1");
            IUser user2 = new SimpleUser(chat, "User2");

            chat.setAdmin(admin);
            chat.addUser(user1);
            chat.addUser(user2);

            user1.sendMassage("Hello, from user1");
            admin.sendMassage("Hello, I am Admin");
        }
    }
}
