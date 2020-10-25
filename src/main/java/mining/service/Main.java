package mining.service;

public class Main {

//    public static ArrayList<Block> blockchain = new ArrayList<Block>();
//    public static int difficulty = 5;
//    public static Wallet walletA;
//    public static Wallet walletB;

//    public static void main(String[] args) {
        //Setup Bouncey castle as a Security Provider
        //Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        //Create the new wallets
//        walletA = new Wallet();
//        walletB = new Wallet();
//        //Test public and private keys
//        System.out.println("Private and public keys:");
//        System.out.println(BlockUtil.getStringFromKey(walletA.getPrivateKey()));
//        System.out.println(BlockUtil.getStringFromKey(walletA.publicKey));
//        //Create a test transaction from WalletA to walletB
//        BlockTransaction transaction = new BlockTransaction(walletA.publicKey, walletB.publicKey, 5, null);
//        //transaction.generateSignature(walletA.privateKey);
//        //Verify the signature works and verify it from the public key
//        System.out.println("Is signature verified");
//        //System.out.println(transaction.verifiySignature());




//        public static ArrayList<Block> blockchain = new ArrayList<Block>();
//    public static int difficulty = 6;

//    public static void main(String[] args) {

//        blockchain.add(new Block("1 block", "0"));
//        System.out.println("Trying to mine block 1...");
//        blockchain.get(0).mineBloc(difficulty);
//
//        blockchain.add(new Block("2 block", blockchain.get(blockchain.size() - 1).getHash()));
//        System.out.println("Trying to mine block 2...");
//        blockchain.get(1).mineBloc(difficulty);
//
//        blockchain.add(new Block("3 block", blockchain.get(blockchain.size() - 1).getHash()));
//        System.out.println("Trying to mine block 3...");
//        blockchain.get(2).mineBloc(difficulty);
//
//        System.out.println("/nBlockchain is Valid: " + isChainValid());
//
//    }
//
//    public static Boolean isChainValid(){
//        Block currentBlock;
//        Block previousBlock;
//        String hashTarget = new String(new char[difficulty]).replace('\0', '0');
//
//
//        //loop through blockchain to check hashes:
//        for(int i=1; i < blockchain.size(); i++) {
//            currentBlock = blockchain.get(i);
//            previousBlock = blockchain.get(i-1);
//            //compare registered hash and calculated hash:
//            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
//                System.out.println("Current Hashes not equal");
//                return false;
//            }
//            //compare previous hash and registered previous hash
//            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
//                System.out.println("Previous Hashes not equal");
//                return false;
//            }
//            //check if hash is solved
//            if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
//                System.out.println("This block hasn't been mined");
//                return false;
//            }
//        }
//        return true;
//    }
}
