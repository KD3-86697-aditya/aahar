using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Aahar_Security_End.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.IdentityModel.Tokens;

namespace Aahar_Security_End.Controllers
{
    [Route("api/")]
    [ApiController]
    public class UserAuthController : ControllerBase
    {
        private ApplicationDbContext _context;
        private IConfiguration _configuration;

        public UserAuthController(IConfiguration configuration, ApplicationDbContext dbContext)
        {
            _configuration = configuration;
            _context = dbContext;
        }

        [AllowAnonymous]
        [HttpPost("login")]
        public IActionResult Login([FromBody] UserLogin userLogin)
        {
            var user = Authenticate(userLogin);

            if (user != null)
            {
                var token = Generate(user);
                return Ok(token);
            }

            return NotFound();
        }

        private string Generate(User user)
        {
            var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]));
            var credentials = new SigningCredentials(securityKey, SecurityAlgorithms.HmacSha256);

            var Claims = GetUserClaims(user);
         
            var token = new JwtSecurityToken(_configuration["Jwt:Issuer"],
                _configuration["Jwt:Audience"],
                Claims,
                expires: DateTime.Now.AddMinutes(30), 
                signingCredentials: credentials
                );
            return new JwtSecurityTokenHandler().WriteToken(token);
        }

        private User Authenticate(UserLogin userLogin)
        {
            var CurrUser = _context.Users.FirstOrDefault(o => o.Email.ToLower() == userLogin.Email.ToLower() && o.PasswordHash == userLogin.PasswordHash);
            if (CurrUser != null)
            {
                return CurrUser;
            }
            return null;
        }

        private List<Claim> GetUserClaims(User user)
        {
            var claims = new List<Claim>
    {
        new Claim(ClaimTypes.Name, user.Username),
        new Claim(ClaimTypes.Email, user.Email ?? ""),
        new Claim(ClaimTypes.Role, user.Role),
        new Claim("UserId", user.Id.ToString()),
        new Claim("FirstName", user.FirstName.ToString() ),
        new Claim("LastName", user.LastName.ToString() ),
        new Claim("PhoneNumber", user.PhoneNumber ?? ""),
        new Claim("LocationId", user.LocationId?.ToString() ?? "0")
    };

            return claims;
        }
    }
}
