"use client"

import Image from "next/image"
import { useState } from "react";
import styles from "./generateRecipe.module.css"
import apron from "../../public/images/apron.svg"

import { Inter } from "next/font/google"

const inter = Inter({
  subsets: ["latin"],
  weight: "400",
  variable: "--font-inter",
})

const GenerateRecipe = () => {
  const [type, setType] = useState("");
  const [diet, setDiet] = useState("");
  const [step, setStep] = useState(1);
  const [recipe, setRecipe] = useState(null);
  const [isSubmitting, setIsSubmitting] = useState(false);

  const handleSubmit = async () => {
    setIsSubmitting(true);
    const payload = {
      tipoDieta: diet,
      tipoComida: type,
    }
    try {
      const response = await fetch(`/api`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(payload),
      });

      if (!response.ok) {
        throw new Error(`Error submitting data: ${response.statusText}`);
      }

      const recipe = await response.json()
      setRecipe(recipe)
      setStep(4)
    } catch (error) {
      console.error("Error submitting data");
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <div>
      {step === 1 && (
        <div className={styles.wrapper}>
          <h2 className={styles.inputHeader}>¿Qué deseas preparar?</h2>
          <label className={`${styles.option} ${type === "desayuno" && styles.active}`}>
            <input
              type="radio"
              value="desayuno"
              checked={type === "desayuno"}
              onChange={(e) => setType(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <hgroup>
              <h3>Desayuno</h3>
              <p>¡Empieza tu día con energía!</p>
            </hgroup>
          </label>
          <label className={`${styles.option} ${type === "almuerzo" && styles.active}`}>
            <input
              type="radio"
              value="almuerzo"
              checked={type === "almuerzo"}
              onChange={(e) => setType(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <hgroup>
              <h3>Almuerzo</h3>
              <p>¡Come rico y nutritivo!</p>
            </hgroup>
          </label>
          <label className={`${styles.option} ${type === "cena" && styles.active}`}>
            <input
              type="radio"
              value="cena"
              checked={type === "cena"}
              onChange={(e) => setType(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <hgroup>
              <h3>Cena</h3>
              <p>¡Cierra tu día con un broche de oro!</p>
            </hgroup>
          </label>
          <button disabled={type.length === 0} className={type.length === 0 ? `${styles.button} ${inter.className} ${styles.disabled}` : `${styles.button} ${inter.className}`} onClick={() => setStep(2)}>Siguiente</button>
        </div>
      )}

      {step === 2 && (
        <div className={styles.wrapper}>
          <h2 className={styles.inputHeader}>¿Qué se te antoja hoy?</h2>
          <label className={`${styles.option} ${diet === "balanceado" && styles.active}`}>
            <input
              type="radio"
              value="balanceado"
              checked={diet === "balanceado"}
              onChange={(e) => setDiet(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <h3>Balanceado</h3>
          </label>
          <label className={`${styles.option} ${diet === "vegetariano" && styles.active}`}>
            <input
              type="radio"
              value="vegetariano"
              checked={diet === "vegetariano"}
              onChange={(e) => setDiet(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <h3>Vegetariano</h3>
          </label>
          <label className={`${styles.option} ${diet === "sin gluten" && styles.active}`}>
            <input
              type="radio"
              value="sin gluten"
              checked={diet === "sin gluten"}
              onChange={(e) => setDiet(e.target.value)}
            />
            <Image src={apron} alt="Delantal" className={styles.apron} />
            <h3>Sin Gluten</h3>
          </label>
          <button className={`${styles.button} ${inter.className}`} onClick={() => setStep(1)}>Volver</button>
          <button disabled={diet.length === 0} className={diet.length === 0 ? `${styles.button} ${inter.className} ${styles.disabled}` : `${styles.button} ${inter.className}`} onClick={() => setStep(3)}>Siguiente</button>
        </div>
      )}

      {step === 3 && (
        <div className={styles.wrapper}>
          <div className={styles.text}>
            <h3>Confirma tus opciones</h3>
            <p>Tipo de comida: <span>{type}</span></p>
            <p>Dieta: <span>{diet}</span></p>
          </div>
          <button className={`${styles.button} ${inter.className}`} onClick={() => setStep(2)}>Volver</button>
          <button disabled={isSubmitting} className={isSubmitting ? `${styles.button} ${inter.className} ${styles.disabled}` : `${styles.button} ${inter.className}`} onClick={handleSubmit}>Generar</button>
        </div>
      )}

      {step === 4 && (
        <div className={styles.wrapper}>
          <div className={styles.text}>
            <h3>Receta generada:</h3>
            <p>{recipe.recetas}</p>
          </div>
          <button disabled={isSubmitting} className={isSubmitting ? `${styles.button} ${inter.className} ${styles.disabled}` : `${styles.button} ${inter.className}`} onClick={handleSubmit}>Regenerar</button>
          <button className={`${styles.button} ${inter.className}`} onClick={() => setStep(1)}>Volver al principio</button>
        </div>
      )}
    </div>
  );
};

export default GenerateRecipe;
