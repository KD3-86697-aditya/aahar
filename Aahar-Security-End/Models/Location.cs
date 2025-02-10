using System;
using System.Collections.Generic;

namespace Aahar_Security_End.Models
{
    public partial class Location
    {
        public Location()
        {
            Users = new HashSet<User>();
        }

        public long Id { get; set; }
        public DateTime? CreatedOn { get; set; }
        public DateTime? UpdatedOn { get; set; }
        public string? City { get; set; }
        public string? Pincode { get; set; }
        public string? State { get; set; }

        public virtual ICollection<User> Users { get; set; }
    }
}
