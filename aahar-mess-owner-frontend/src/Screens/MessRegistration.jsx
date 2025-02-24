import React, { useState } from "react";
import registerImg from "../images/user_images/registerImg.jpg";

function MessRegistration() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [phone, setPhone] = useState("");
const [city,setCity]=useState("");
const [pincode,setPincode]=useState("");
const [state,setState]=useState("");


  const [messName, setMessName] = useState("");

  const [messAddress, setMessAddress] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const formData = {
      email,
      password,
      confirmPassword,
      firstName,
      lastName,
      phone,
      messName,
      messAddress,
    };

    console.log(formData);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gradient-to-r from-purple-200 via-purple-300 to-purple-400">
      <div className="flex w-full max-w-6xl max-h-[600px] bg-white shadow-md rounded-lg overflow-hidden">
        <div className="flex-1 flex items-center justify-center">
          <div
            style={{ backgroundImage: `url(${registerImg})` }}
            className="bg-center bg-gray-400 h-full w-full bg-no-repeat transition duration-500 ease-in-out hover:bg-gray-500 bg-blend-multiply"
          >
            <div className="px-4 text-center py-24 lg:py-56">
              <h1 className="mb-4 text-lg font-bold tracking-tight leading-none text-white mt-8">
                Already registered your mess? Click Login
              </h1>

              <div className="flex flex-col space-y-4 sm:flex-row sm:justify-center sm:space-y-0">
                <a
                  href="/login"
                  className="inline-flex justify-center items-center py-3 px-5 text-base font-medium text-center text-white rounded-lg bg-purple-600 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 dark:focus:ring-purple-900"
                >
                  Get started
                  <svg
                    className="w-3.5 h-3.5 ms-2 rtl:rotate-180"
                    aria-hidden="true"
                    xmlns="http://www.w3.org/2000/svg"
                    fill="none"
                    viewBox="0 0 14 10"
                  >
                    <path
                      stroke="currentColor"
                      strokeLinecap="round"
                      strokeLinejoin="round"
                      strokeWidth="2"
                      d="M1 5h12m0 0L9 1m4 4L9 9"
                    />
                  </svg>
                </a>
                <a
                  href="#"
                  className="inline-flex justify-center hover:text-gray-900 items-center py-3 px-5 sm:ms-4 text-base font-medium text-center text-white rounded-lg border border-white hover:bg-purple-100 focus:ring-4 focus:ring-purple-400"
                >
                  Learn more
                </a>
              </div>
            </div>
          </div>
        </div>

<div
    style={{
      flex: 1,
      padding: "20px",
      overflowY: "auto",
      maxHeight: "100vh",
    }}
  >

        <form className="flex-1 p-8" onSubmit={handleSubmit}>
          <h5 className="text-center text-2xl font-serif font-bold mb-3">
            Mess Owner Registration
          </h5>
          <div className="mb-5">
            <label
              htmlFor="email"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Your email
            </label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
              placeholder="name@domain.com"
              required
            />
          </div>
          <div className="mb-5">
            <label
              htmlFor="password"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Password
            </label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
              placeholder="******"
              required
            />
          </div>
          <div className="mb-5">
            <label
              htmlFor="confirmPassword"
              className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
            >
              Confirm password
            </label>
            <input
              type="password"
              id="confirmPassword"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
              placeholder="******"
              required
            />
          </div>
          <div className="grid md:grid-cols-2 md:gap-6">
            <div className="mb-5">
              <label
                htmlFor="firstName"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                First Name
              </label>
              <input
                type="text"
                id="firstName"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="John"
                required
              />
            </div>
            <div className="mb-5">
              <label
                htmlFor="lastName"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Last Name
              </label>
              <input
                type="text"
                id="lastName"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="Doe"
                required
              />
            </div>
          </div>
          <div className="grid md:grid-cols-2 md:gap-6">
            <div className="mb-5">
              <label
                htmlFor="phone"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Phone Number
              </label>
              <input
                type="text"
                id="phone"
                value={phone}
                onChange={(e) => setPhone(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="123-456-7890"
                required
              />
            </div>

            <div className="mb-5">
              <label
                htmlFor="city"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                City
              </label>
              <input
                type="text"
                id="city"
                value={city}
                onChange={(e) => setMessName(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="Mess Name"
                required
              />
            </div>



            <div className="mb-5">
              <label
                htmlFor="pincode"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                Pincode
              </label>
              <input
                type="text"
                id="city"
                value={messName}
                onChange={(e) => setPincode(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="Enter your pincode"
                required
              />
            </div>


            <div className="mb-5">
              <label
                htmlFor="state"
                className="block mb-2 text-sm font-medium text-gray-900 dark:text-white"
              >
                State
              </label>
              <input
                type="text"
                id="state"
                value={state}
                onChange={(e) => setState(e.target.value)}
                className="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                placeholder="Enter State name"
                required
              />
            </div>
          </div>
          
          <button
            type="submit"
            className="w-full text-white bg-purple-600 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
          >
            Register
          </button>
        </form>

  </div>
</div>

</div>
  );
}

export default MessRegistration;












































// import { Toast } from 'flowbite-react'
// import React, { useState } from 'react'
// import { Link } from 'react-router-dom'
// import { toast } from 'react-toastify'


// function MessRegistration() {


//   const [firstName, setfirstName] = useState('')
//   const [lastName, setlastName] = useState('')
//   const [email, setEmail] = useState('')
//   const [password, setPassword] = useState('')
//   const [confirmPassword, setconfirmPassword] = useState('')
//   const [phoneNo, setPhoneNo] = useState('')

//   const onSignup = async () => {
//     if (firstName.length == 0) {
//       toast.warn("please enter first Name")
//     }
//     else if (lastName.length == 0) {
//       toast.warn("please enter last name")
//     }
//     else if (email.length == 0) {
//       toast.warn("plese enter email")
//     }
//     else if (password.length == 0) {
//       toast.warn("plese enter password")
//     }
//     else if (confirmPassword.length == 0) {
//       toast.warn("please confirm password")
//     }
//     else if (password != confirmPassword) {
//       toast.warn('password should match')
//     }
//     else if (phoneNo.length = 0) {
//       toast.warn("phone number cannot be null")
//     }
//   }




//   return (
//     <div>

//       <h2 className='header'>REGISTRATION PAGE</h2>

//       <section class="bg-gray-50 dark:bg-gray-900">
//   <div class="flex flex-col items-center justify-center px-6 py-8 mx-auto md:h-screen lg:py-0">
//       <a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
//           <img class="w-8 h-8 mr-2" src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/logo.svg" alt="logo"/>
//           Flowbite    
//       </a>
//       <div class="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
//           <div class="p-6 space-y-4 md:space-y-6 sm:p-8">
//               <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
//                   Create an account
//               </h1>



//               <form class="space-y-4 md:space-y-6" action="#">
//         <div>
//           <label for="name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your Name</label>
//           <input
//             type="text"
//             name="name"
//             id="name"
//             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
//             placeholder="Enter your name"
//             required
//           />
//         </div>

//         <div>
//           <label for="phone" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your Phone Number</label>
//           <input
//             type="tel"
//             name="phone"
//             id="phone"
//             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
//             placeholder="Enter your phone number"
//             pattern="[0-9]{10}"
//             required
//           />
//         </div>


//         <div>
//           <label for="email" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your email</label>
//           <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" placeholder="name@company.com" required="" />
//         </div>


//         <div>
//           <label for="mess_name" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Mess Name</label>
//           <input
//             type="text"
//             name="mess_name"
//             id="mess_name"
//             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
//             placeholder="Enter the name of your mess"
//             required
//           />
//         </div>

//         <div>
//           <label for="address" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Address</label>
//           <textarea
//             name="address"
//             id="address"
//             class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
//             placeholder="Enter the complete address of your mess"
//             rows="4"
//             required
//           ></textarea>
//         </div>



//         <div>
//           <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
//           <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="" />
//         </div>
//         <div>
//           <label for="confirm-password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Confirm password</label>
//           <input type="confirm-password" name="confirm-password" id="confirm-password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" required="" />
//         </div>
//         <div class="flex items-start">
//           <div class="flex items-center h-5">
//             <input id="terms" aria-describedby="terms" type="checkbox" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800" required="" />
//           </div>
//           <div class="ml-3 text-sm">
//             <label for="terms" class="font-light text-gray-500 dark:text-gray-300">I accept the <a class="font-medium text-primary-600 hover:underline dark:text-primary-500" href="#">Terms and Conditions</a></label>
//           </div>
//         </div>
//         <button type="submit" class="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800">Create an account</button>
//         <p class="text-sm font-light text-gray-500 dark:text-gray-400">
//           Already have an account? <a href="/login" class="font-medium text-primary-600 hover:underline dark:text-primary-500">Login here</a>
//         </p>
//       </form>
      
//           </div>
//       </div>
//   </div>
// </section>

//     </div>
//   )
// }

// export default MessRegistration
