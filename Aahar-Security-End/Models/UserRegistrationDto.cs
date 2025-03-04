﻿namespace Aahar_Security_End.Models
{
    public class UserRegistrationDto
    {
        public string Email { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Password { get; set; }
        public string PhoneNumber { get; set; }
        public string Username { get; set; }

        // Location details
        public string City { get; set; }
        public double Latitude { get; set; }
        public double Longitude { get; set; }
        public string Pincode { get; set; }
        public string State { get; set; }
    }
}
