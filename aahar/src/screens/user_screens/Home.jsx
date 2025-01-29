import { Outlet } from "react-router-dom";
import Footer from "../../components/Footer";
import Navbar from "../../components/Navbar";
import dashImg from "../../images/user_images/dashboard.jpg";
function Home() {
  return (
    <div>
      <Navbar />
      <section
        style={{ backgroundImage: `url(${dashImg})` }}
        className="bg-center bg-gray-700 bg-cover bg-no-repeat bg-blend-multiply h-screen"
      >
        <div class="px-4 mx-auto max-w-screen-xl text-center py-24 lg:py-56">
          <h1 class="mb-4 text-4xl font-extrabold tracking-tight leading-none text-white md:text-5xl lg:text-6xl">
            "Connecting you to the food you love, every day"
          </h1>
          <p class="mb-8 text-lg font-normal text-gray-300 lg:text-xl sm:px-16 lg:px-48">
            Aahar will Connecting you to the best food vendors – enjoy fresh
            meals with ease and convenience!
          </p>
          <div class="flex flex-col space-y-4 sm:flex-row sm:justify-center sm:space-y-0">
            <a
              href="#"
              class="inline-flex justify-center items-center py-3 px-5 text-base font-medium text-center text-white rounded-lg bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:focus:ring-blue-900"
            >
              Get started
              <svg
                class="w-3.5 h-3.5 ms-2 rtl:rotate-180"
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
              class="inline-flex justify-center hover:text-gray-900 items-center py-3 px-5 sm:ms-4 text-base font-medium text-center text-white rounded-lg border border-white hover:bg-gray-100 focus:ring-4 focus:ring-gray-400"
            >
              Let's Go
            </a>
          </div>
        </div>
      </section>
      <section class="bg-white dark:bg-gray-900">
        <div class="py-8 px-4 mx-auto max-w-screen-xl lg:py-16">
          <div class="bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 rounded-lg p-8 md:p-12 mb-8">
            <h1 class="text-gray-900 dark:text-white text-3xl md:text-5xl font-extrabold mb-2">
              How Aahar is Revolutionizing the Way Students and Employees Order
              Food
            </h1>
            <p class="text-lg font-normal text-gray-500 dark:text-gray-400 mb-6">
              Learn how Aahar connects students and employees to reliable food
              vendors, offering fresh, healthy meals tailored to individual
              needs. We explore how technology is enhancing convenience, meal
              variety, and dietary preferences for all.
            </p>
            <a
              href="#"
              class="inline-flex justify-center items-center py-2.5 px-5 text-base font-medium text-center text-white rounded-lg bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:focus:ring-blue-900"
            >
              Read more
              <svg
                class="w-3.5 h-3.5 ms-2 rtl:rotate-180"
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
          </div>
          <div class="grid md:grid-cols-2 gap-8">
            <div class="bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 rounded-lg p-8 md:p-12">
              <h2 class="text-gray-900 dark:text-white text-3xl font-extrabold mb-2">
                Why Freshness and Quality Matter in Food Delivery Services
              </h2>
              <p class="text-lg font-normal text-gray-500 dark:text-gray-400 mb-4">
                Quality is key when it comes to food delivery. This blog delves
                into why Aahar partners with the best vendors to ensure you
                always enjoy fresh, nutritious meals that meet your
                expectations.
              </p>
              <a
                href="#"
                class="text-blue-600 dark:text-blue-500 hover:underline font-medium text-lg inline-flex items-center"
              >
                Read more
                <svg
                  class="w-3.5 h-3.5 ms-2 rtl:rotate-180"
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
            </div>
            <div class="bg-gray-50 dark:bg-gray-800 border border-gray-200 dark:border-gray-700 rounded-lg p-8 md:p-12">
              <h2 class="text-gray-900 dark:text-white text-3xl font-extrabold mb-2">
                Aahar: The One-Stop Solution for Customizing Your Meals{" "}
              </h2>
              <p class="text-lg font-normal text-gray-500 dark:text-gray-400 mb-4">
                Not all meals are created equal. With Aahar, users can filter
                and customize their meal choices based on preferences like
                vegetarian, vegan, gluten-free, or low-calorie. Learn more about
                how we cater to every need.
              </p>
              <a
                href="#"
                class="text-blue-600 dark:text-blue-500 hover:underline font-medium text-lg inline-flex items-center"
              >
                Read more
                <svg
                  class="w-3.5 h-3.5 ms-2 rtl:rotate-180"
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
            </div>
          </div>
        </div>
      </section>
      <Footer />
      <Outlet />
    </div>
  );
}

export default Home;
