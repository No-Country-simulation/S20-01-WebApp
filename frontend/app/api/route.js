// import { redirect } from 'next/navigation'

export async function POST(request) {
  try {
    const response = await fetch(`${process.env.API_URL}/menus/recetas`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(await request.json()),
    });

    const recipe = await response.json()

    return new Response(JSON.stringify(recipe), { status: 200, headers: { 'Content-Type': 'application/json' } });
  } catch (error) {
    console.error('Error:', error);
    return new Response(JSON.stringify({ error: 'Internal Server Error' }), { status: 500 });
  }
}
