using System;
using System.Collections.Generic;

namespace Aahar_Security_End.Models
{
    public  class UserRespDto
    {
        public long Id { get; set; }

        public string? Email { get; set; }
        public string? FirstName { get; set; }
        public string? LastName { get; set; }
       public string? PhoneNumber { get; set; }
        public string Role { get; set; } = null!;
        public string Username { get; set; } = null!;
        public long? LocationId { get; set; }
    }
}
