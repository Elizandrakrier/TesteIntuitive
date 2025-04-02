# pylint: disable=astroid-error
import pandas as pd
from flask import Flask, request, jsonify

app = Flask(__name__)

df = pd.read_csv("Relatorio_cadop.csv", sep=",", encoding="latin1")


@app.route("/buscar", methods=["GET"])
def buscar_operadoras():
    termo = request.args.get("termo", "").lower()

    resultados = df[df["Razao_Social"].str.lower().str.contains(termo)]

    return jsonify(resultados.to_dict(orient="records"))


if __name__ == "__main__":
    app.run(debug=True, port=5050)
