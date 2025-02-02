'use client'

import { useState } from 'react';
import { useRouter } from 'next/navigation';

const GenerateRecipe = () => {
  const [diet, setDiet] = useState('');
  const [type, setType] = useState('');
  const [step, setStep] = useState(1);
  const [recipe, setRecipe] = useState(null);
  const router = useRouter();

  const handleSubmit = async () => {
    const payload = {
      tipoDieta: diet,
      tipoComida: type,
    }

    const response = await fetch(`/api`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(payload),
    });

    if (response.ok) {
      const recipe = await response.json()
      console.log(recipe)
      setRecipe(recipe)
      setStep(4)
    } else {
      console.error('Error submitting data');
    }
  };

  return (
    <div>
      {step === 1 && (
        <div>
          <h2>Step 1: Enter Parameter 1</h2>
          <input
            type="text"
            value={diet}
            onChange={(e) => setDiet(e.target.value)}
          />
          <button onClick={() => setStep(2)}>Next</button>
        </div>
      )}

      {step === 2 && (
        <div>
          <h2>Step 2: Enter Parameter 2</h2>
          <input
            type="text"
            value={type}
            onChange={(e) => setType(e.target.value)}
          />
          <button onClick={() => setStep(3)}>Next</button>
          <button onClick={() => setStep(1)}>Back</button>
        </div>
      )}

      {step === 3 && (
        <div>
          <h2>Confirm Submission</h2>
          <p>Parameter 1: {diet}</p>
          <p>Parameter 2: {type}</p>
          <button onClick={handleSubmit}>Submit</button>
          <button onClick={() => setStep(2)}>Back</button>
        </div>
      )}

      {step === 4 && (
        <div>
          <h2>Recipe</h2>
          <p>{recipe.recetas}</p>
          <button onClick={handleSubmit}>Regenerate</button>
          <button onClick={() => setStep(1)}>Back to the start</button>
        </div>
      )}
    </div>
  );
};

export default GenerateRecipe;
