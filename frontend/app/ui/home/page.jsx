import ButtonPrimary from '@/components/misc/ButtonPrimary';
import Image from 'next/image';
import Link from 'next/link';
ButtonPrimary


export default function One() {
    return (
      <>
      <div className="h-auto lg:mb-16 justify-center rounded-lg">
        
        <div className="z-0">
          <Image
            alt="Colorful utensils background"
            className="w-full h-full object-cover" // Hide on mobile (default) and show on medium screens and up
            src="/images/tenedor.svg"
            quality={100}
            fill
          />
        </div>
          

          </div>
          <div className="absolute font-extrabold text-4xl items-center z-10" >
            <div className="relative w-[430] h-[1080] flex flex-col justify-center items-center bg-gray-50 overflow-hidden">
            {/* Fondo */}
            <div className="absolute inset-0 z-0">
              <Image
                alt="Background utensils"
                src="/images/tenedor.svg"
                quality={100}
                fill
                className="w-full h-full object-cover"
              />
            </div>

            {/* Logo */}
            <div className="relative  z-20 flex flex-col items-center">
              <Image
                alt="Logo background"
                src="/images/Logoapp.svg"
                width={200} // Tamaño optimizado para móviles
                height={200}
                className="mb-6"
              />
            </div>

            {/* Texto y botón */}
            <div className="relative z-30 flex flex-col items-center mt-8 px-4 text-center">
              <p className="text-black font-extrabold text-2xl sm:text-4xl leading-normal">
                Te acompañamos a planificar tus comidas <br /> de manera fácil y <br />
                efectiva.
              </p>

              <div className="mt-8">
                <Link href="/login">
                  <ButtonPrimary className="px-6 py-3 w-full sm:w-auto">INICIO DE SESIÓN</ButtonPrimary>
                </Link>
              </div>
            </div>
          </div>
                    
      </div>
          
      </>
      
    );
  }