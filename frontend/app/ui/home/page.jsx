import {great} from '@/app/lib/fonts'

export default function One() {
    return (
      <div className="w-full pt-5 shadow-lg rounded-lg overflow-hidden mb-20">
        <div className="text-center md:text-sm">
          <h1 className={`${great.variable} text-9xl text-white font-great `}>
            Nutri
            <span className="text-yellow-400"> Wise</span>
          </h1>
          <p className="text-white text-lg">
            NUTRICIÓN SABIA, SALUD EN CADA ELECCIÓN
          </p>
        </div>
        <div className="flex items-center justify-center relative">
          <img
            alt="Colorful utensils background"
            className="w-[1920px] mt-10 h-[400px]"
            height="200"
            src="https://storage.googleapis.com/a1aa/image/ACFqoZKnZmKLMFhEGE0OqKyfT3jmc0sf7G28rgMYdnsEugGUA.jpg"
            width="600"
          />
          <img
            alt="Colorful utensils background"
            className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 -rotate-12"
            height="250"
            src="/images/logo.svg"
            width="250"
          />
           
        </div> 
      </div>
    );
  }