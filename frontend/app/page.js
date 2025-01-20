import React from "react";
import NavigationBar from "./ui/shared/navigation-bar";
import One from "./ui/home/page";
import {inter} from '@/app/lib/fonts'

export default function Home() {
  return (
    <div className={`${inter.variable} font-inter`}>
      <NavigationBar/>
      <div className="divide-y divide-solid divide-grayText/20">
        <One/>
      </div>
    </div>
  );
}
