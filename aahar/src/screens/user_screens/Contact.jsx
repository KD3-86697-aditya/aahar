import { useState } from "react";
import Navbar from "../../components/Navbar";

function Contact() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [subject, setSubject] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Name:", name);
    console.log("Email:", email);
    console.log("Subject:", subject);
    console.log("Message:", message);
  };

  return (
    <>
      <Navbar />
      <div className="bg-gradient-to-r from-purple-200 via-purple-400 to-purple-500 pt-[90px] pb-[40px]">
        <h1 className="text-center text-3xl font-serif font-bold ">
          Contact Us
        </h1>

        <form className="max-w-md mx-auto mt-10" onSubmit={handleSubmit}>
          <label
            htmlFor="name"
            className="block mb-2 text-sm font-bold text-gray-900 dark:text-white"
          >
            Your Name
          </label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-600 dark:focus:border-purple-500"
            placeholder="Spiderman"
          />

          <label
            htmlFor="email"
            className="block mt-4 mb-2 text-sm font-bold text-gray-900 dark:text-white"
          >
            Your Email
          </label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-600 dark:focus:border-purple-500"
            placeholder="spider.man@example.com"
          />

          <label
            htmlFor="subject"
            className="block mt-4 mb-2 text-sm font-bold text-gray-900 dark:text-white"
          >
            Subject
          </label>
          <input
            type="text"
            id="subject"
            value={subject}
            onChange={(e) => setSubject(e.target.value)}
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-600 dark:focus:border-purple-500"
            placeholder="Subject"
          />

          <label
            htmlFor="message"
            className="block mt-4 mb-2 text-sm font-bold text-gray-900 dark:text-white"
          >
            Your Message
          </label>
          <textarea
            id="message"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            rows="4"
            className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-purple-500 focus:border-purple-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-purple-600 dark:focus:border-purple-500"
            placeholder="Your message..."
          ></textarea>

          <div className="text-center mt-6">
            <button
              type="submit"
              className="w-32 text-white bg-gradient-to-r from-purple-500 via-purple-600 to-purple-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-green-300 dark:focus:ring-green-800 shadow-lg shadow-purple-500/50 dark:shadow-lg dark:shadow-purple  -800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2"
            >
              Send
            </button>
          </div>
        </form>
      </div>
    </>
  );
}

export default Contact;
