import Image from "next/image";
import {great, inter} from '@/app/lib/fonts'
import Link from "next/link";


export default async function NavigationBar() {


  return (
    <>
    
    <div className="fixed top-0 left-0 right-0 z-20 px-4 sm:px-8 shadow-t
     bg-[#0A9700] rounded-b-[3rem] h-[20vh] flex items-end">
      <div className={`${great.variable} ${inter.variable} z-10 flex items-center mr-auto`}>
      <div className="pl-5 pb-8 text-center md:text-sm">
          <h1 className="text-7xl text-white font-great">
            Nutri
            <span className="text-yellow-400 "> Wise</span>
          </h1>
          <p className="text-yellow-400 text-3xl font-great">
            Nutrición sabia, salud en cada elección
          </p>
        </div>
      </div>
    
    </div>
    
    </>
    
  );
}
