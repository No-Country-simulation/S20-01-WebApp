import React, { useMemo } from "react";
import Image from "next/image";
import ButtonPrimary from "./misc/ButtonPrimary";
import { motion } from "framer-motion";
import getScrollAnimation from "../utils/getScrollAnimation";
import ScrollAnimationWrapper from "./Layout/ScrollAnimationWrapper";

const Hero = () => {
  const scrollAnimation = useMemo(() => getScrollAnimation(), []);

  return (
    <div className="max-w-screen-xl mt-60 px-8 xl:px-16 mx-auto" id="about">
      <ScrollAnimationWrapper>
        <motion.div
          className="grid grid-flow-row sm:grid-flow-col gap-8 py-6 sm:py-16 relative"
          variants={scrollAnimation}
        >
          {/* Logo or additional content */}
          <div className="flex w-full">
            <motion.div className="h-full w-full" variants={scrollAnimation}>
              <Image
                src="/assets/Logoapp.svg"
                alt="Nutri"
                quality={100}
                width={612}
                height={383}
                layout="responsive"
              />
            </motion.div>
          </div>

          {/* Foreground content */}
          <div className="flex flex-col items-center z-10">
            <h1 className="text-3xl lg:text-4xl xl:text-5xl font-medium text-black-600 leading-normal text-center">
              <strong>
                Te acompañamos a<br /> planificar tus comidas
                <br /> de manera fácil y<br /> efectiva.
              </strong>
            </h1>
            <ButtonPrimary className="rounded-full bg-[#0A9700] text-white py-2 px-6 mt-4">
              INICIO DE SESIÓN
            </ButtonPrimary>
          </div>
        </motion.div>
      </ScrollAnimationWrapper>
    </div>
  );
};

export default Hero;
