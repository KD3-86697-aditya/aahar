using System;
using System.Collections.Generic;

namespace Aahar_Security_End.Models
{
    public partial class User
    {
        public long Id { get; set; }
        public DateOnly? CreatedOn { get; set; }
        public DateTime? UpdatedOn { get; set; }
        public string? Email { get; set; }
        public string? FirstName { get; set; }
        public string? LastName { get; set; }
        public string PasswordHash { get; set; } = null!;
        public string? PhoneNumber { get; set; }
        public string Role { get; set; } = null!;
        public string Username { get; set; } = null!;
        public long? LocationId { get; set; }
    }
}
