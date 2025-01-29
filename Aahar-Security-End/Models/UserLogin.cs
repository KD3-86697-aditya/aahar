namespace Aahar_Security_End.Models
{
    public class UserLogin
    {
        public string? Email { get; set; }
        public string PasswordHash { get; set; } = null!;

    }
}
