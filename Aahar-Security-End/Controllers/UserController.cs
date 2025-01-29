using System.Security.Claims;
using Aahar_Security_End.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Aahar_Security_End.Controllers
{
    [Route("api/")]
    [ApiController]
    public class UserController : ControllerBase
    {

        public UserController() { }

        [HttpGet("public")]
        public IActionResult Get()
        {
            return Ok("Hey whats up");
        }

        [HttpGet("user")]
        [Authorize(Roles ="MESS_OWNER")]
        public IActionResult GetLoggedInUser()
        {
            var CurrUser = GetCurrentUser();
            return Ok(CurrUser);
        }
        private UserRespDto GetCurrentUser()
        {
            
            var identity = HttpContext.User.Identity as ClaimsIdentity;

            if (identity != null) { 
                var userClaims = identity.Claims;
                return new UserRespDto
                {
                    Id = long.Parse(userClaims.FirstOrDefault(c => c.Type == "UserId")?.Value ?? "0"),
                    Username = userClaims.FirstOrDefault(c => c.Type == ClaimTypes.Name)?.Value,
                    Email = userClaims.FirstOrDefault(c => c.Type == ClaimTypes.Email)?.Value,
                    Role = userClaims.FirstOrDefault(c => c.Type == ClaimTypes.Role)?.Value,
                    FirstName = userClaims.FirstOrDefault(c => c.Type == "FirstName")?.Value,
                    LastName = userClaims.FirstOrDefault(c => c.Type == "LastName")?.Value,
                    PhoneNumber = userClaims.FirstOrDefault(c => c.Type == "PhoneNumber")?.Value,
                    LocationId = long.Parse(userClaims.FirstOrDefault(c => c.Type == "LocationId")?.Value ?? "0")
                };
            }
                return null;

        }
    }
}
