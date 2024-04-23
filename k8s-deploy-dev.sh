#!/bin/bash

apply_common() {
  kubectl apply -f deploy/dev/secret.yaml
  kubectl apply -f deploy/dev/deployment.yaml
  kubectl apply -f deploy/dev/service.yaml
  kubectl apply -f deploy/dev/config-map.yaml
  kubectl apply -f deploy/dev/secret-map.yaml
}

change_namespace() {
  kubens aincrad
}

apply_kayaba() {
  kubectx kind-kayaba
#  kubectl apply -f deploy/dev/namespace.yaml
  change_namespace
  apply_common
  kubectl apply -f deploy/dev/config-map.ka.yaml
  kubectl apply -f deploy/dev/ingress.ka.yaml
}

apply_kirito() {
  kubectx kind-kirito
#  kubectl apply -f deploy/dev/namespace.yaml
  change_namespace
  apply_common
  kubectl apply -f deploy/dev/config-map.ki.yaml
  kubectl apply -f deploy/dev/ingress.ki.yaml
}

delete_common() {
  kubectl delete -f deploy/dev/secret.yaml
  kubectl delete -f deploy/dev/deployment.yaml
  kubectl delete -f deploy/dev/service.yaml
  kubectl delete -f deploy/dev/config-map.yaml
  kubectl delete -f deploy/dev/secret-map.yaml
}

delete_kind() {
  kubectx kind-kayaba
  change_namespace
  delete_common
  kubectl delete -f deploy/dev/config-map.ka.yaml
  kubectl delete -f deploy/dev/ingress.ka.yaml
#  kubectl delete -f deploy/dev/namespace.yaml
}

delete_minikube() {
  kubectx kind-kirito
  change_namespace
  delete_common
  kubectl delete -f deploy/dev/config-map.ki.yaml
  kubectl delete -f deploy/dev/ingress.ki.yaml
#  kubectl delete -f deploy/dev/namespace.yaml
}

if [ "$1" == "all" ]; then
  apply_kayaba
  apply_kirito

elif [ "$1" == "delete-all" ]; then
  delete_kind
  delete_minikube

else
  echo "Opção inválida. Informe \"ka\", \"ki\" ou \"all\""
  echo ""
  echo "Exemplo: "
  echo "$ ./k8s-deploy-dev.sh all"
  echo "ou"
  echo "$ ./k8s-deploy-dev.sh delete-all"
fi
