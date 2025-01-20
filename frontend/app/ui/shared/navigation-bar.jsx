import Image from "next/image";
import Link from "next/link";


export default async function NavigationBar() {


  return (
    <div className="relative hidden lg:flex items-center justify-between bg-[#d9fbca] w-auto h-[90px]">
      <div className="z-10 flex items-center mr-auto">
        <Link href="/">
          <Image
            className="h-full object-cover object-center"
            alt="Logo del refugio"
            src="/images/logo.svg"
            width={100}
            height={60}
          />
        </Link>
      </div>
      
     
      
        <Link href="/">
          <button className="rounded-md w-28 h-10 bg-[#f2d137] py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:outline hover:outline-offset-1 hover:outline-[#fcfcfc] mr-10 ml-10 ">
            ¡Comienza!
          </button>
        </Link>
    
    </div>
  );
}
